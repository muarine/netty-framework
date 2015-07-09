package com.netty.core.server;

public class FileItem {
	private String filename;
	private String mimeType;
	private String fieldName;
	private String fileExt;

	public FileItem(String filename, String mimeType, String fieldName,
			String fileExt) {
		this.filename = filename;
		this.mimeType = mimeType;
		this.fieldName = fieldName;
		this.fileExt = fileExt;
	}

	public static FileItem parseFileItem(String content) {
		if (content == null)
			return null;
		String filename = null;
		String mimeType = null;
		String name = null;
		String fileExt = null;
		String[] rows = content.split("\r\n");
		for (String row : rows) {
			int idx = row.indexOf(":");
			if (idx > 0) {
				String key = row.substring(0, idx);
				if ("Content-Disposition".equals(key)) {
					String val = row.substring(idx + 1);
					String[] items = val.split(";");
					for (String item : items) {
						String[] kv = item.split("=");
						String k = kv[0].trim();
						if ("name".equals(k)) {
							name = kv[1].replace("\"", "");
						} else if ("filename".equals(k)) {
							filename = kv[1].replace("\"", "");
							String[] split = filename.split("\\.");
							fileExt = split[split.length - 1];
						}
					}
				} else if ("Content-Type".equals(key)) {
					String val = row.substring(idx + 1);
					mimeType = val.trim();
				}
			}
		}
		return new FileItem(filename, mimeType, name, fileExt);
	}

	public String getFilename() {
		return filename;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getFileExt() {
		return fileExt;
	}

	@Override
	public String toString() {
		return String.format("name=%s  mimetype=%s  filename=%s fileExt=%s",
				this.fieldName, this.mimeType, this.filename, this.fileExt);
	}
}