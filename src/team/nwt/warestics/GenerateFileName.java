package team.nwt.warestics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class GenerateFileName {
	
	/**
	 * 根据文件类别生成文件的名字,文件的命名规则是:文件目录/生成时间-uuid（全球唯一编码）.文件类别
	 * @param fileDir 文件的存储路径
	 * @param fileType 文件的类别
	 * @return     文件的名字 
	 */
	public String generateFileName(String fileDir,String fileType)
	{
		String saveFileName = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSS");
		saveFileName += format.format(Calendar.getInstance().getTime());

		UUID uuid = UUID.randomUUID(); //全球唯一编码

		saveFileName += "-" + uuid.toString();
		saveFileName += "." + fileType;

		saveFileName = fileDir + File.separator + saveFileName;

		return saveFileName;
	}
}
