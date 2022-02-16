package me.mikholsky.task7.facade;

public class VideoFile {
	private String name;
	private String codecType;

	public VideoFile(String name) {
		this.name = name;
		this.codecType = name.substring(name.lastIndexOf('.') + 1);
	}

	public String getName() {
		return name;
	}

	public String getCodecType() {
		return codecType;
	}
}
