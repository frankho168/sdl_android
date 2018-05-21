package com.smartdevicelink.proxy.rpc;

import android.support.annotation.NonNull;

import com.smartdevicelink.api.FileManager;
import com.smartdevicelink.api.SdlManager;
import com.smartdevicelink.proxy.RPCStruct;
import com.smartdevicelink.proxy.rpc.enums.FileType;

/**
 * An object that contains all of the necessary information to upload a file to a head unit.
 */
public class SdlFile extends RPCStruct {
	public static final String KEY_SDL_FILE_NAME= "sdlFileName";
	public static final String KEY_FILE_PATH= "filePath";
	public static final String KEY_FILE_DATA= "fileData";
	public static final String KEY_FILE_TYPE= "fileType";
	public static final String KEY_PERSISTENT_FILE= "persistentFile";

	public SdlFile() {}

	/**
	 * Set the file name for the file to be uploaded. This parameter is required <br>
	 * <strong>If a file being uploaded has the same name as an already uploaded file, the new file will overwrite the previous file.</strong>
	 * Easily check for uploaded files with SdlManager.getFileManager().getRemoteFileNames()
	 * @param fileName - the name of the file
	 */
	public void setSdlFileName(@NonNull String fileName) {
		setValue(KEY_SDL_FILE_NAME, fileName);
	}

	/**
	 * @return - the set name of the SDLFile object
	 */
	public String getSdlFileName() {
		return getString(KEY_SDL_FILE_NAME);
	}

	/**
	 * Set the resource ID of the file you want to upload
	 * If this parameter is set, you do not need to set the file data.
	 * @param resource - the URI of the file to be uploaded.
	 */
	public void setFilePath(int resource) { setValue(KEY_FILE_PATH, resource); }

	/**
	 * @return - The resource ID of the file
	 */
	public int getFilePath() { return (int) getValue(KEY_FILE_PATH); }

	/**
	 * Set the file data as a byte array. If this is set, there is no need to set the
	 * file path
	 * @param fileData - the data of the file as a byte array
	 */
	public void setFileData(byte[] fileData) { setValue(KEY_FILE_DATA, fileData); }

	/**
	 * @return - a byte array of the file data
	 */
	public byte[] getFileData() { return (byte[]) getValue(KEY_FILE_DATA); }

	/**
	 * Set the file type of the file being uploaded.
	 * @param fileType - the {@link FileType} of the file being uploaded.
	 */
	public void setFileType(@NonNull FileType fileType) { setValue(KEY_FILE_TYPE, fileType); }

	/**
	 * @return - the {@link FileType} - of the uploaded file
	 */
	public FileType getFileType() { return (FileType) getValue(KEY_FILE_TYPE); }

	/**
	 * Set whether or not the file should persist on disk between car ignition cycles.
	 * Persistence should be used for images or files relating to your UI, and not for dynamic aspects, such as Album Artwork.<br>
	 * <strong>Be aware that persistence will not work if space on the head unit is limited.</strong>
	 * @param persistentFile - True or False. <strong>If not set, will default to false</strong>
	 */
	public void setPersistentFile(Boolean persistentFile) { setValue(KEY_PERSISTENT_FILE, persistentFile); }

	/**
	 * @return - A Boolean of whether the file should persist on disk between car ignition cycles.
	 */
	public Boolean getPersistentFile() { return getBoolean(KEY_PERSISTENT_FILE); }

}
