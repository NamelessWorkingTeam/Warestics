package team.nwt.warestics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GenerateFold {
	/**
	 * 查询当前生成的excel需要存在在哪个路径，如果存在则存储在相应的位置，否则生成改目录， 每天生成一个文件夹，文件夹的命名规则为 年月日的时间戳
	 * @param foldName 生成excel保存路径
	 * @return   现在的excel需要保存路径
	 */
	public String getFold(String foldName)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		String todayStr = format.format(Calendar.getInstance().getTime());

		String foldPath = foldName + File.separator + todayStr; 

		File file = new File(foldPath);

		if(!file.exists() && !file.isDirectory())
		{
			System.out.println("不存在");
			file.mkdirs();
		}
		else
		{
			System.out.println("存在");
		}
		return foldPath;
	}
}
