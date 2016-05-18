package com.hadoop.fileoper;

import com.hadoop.constant.HadoopConstant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Desc 查看HDFS文件的最后修改时间
 * Created by zzp
 * on 2016/5/17.23:18
 */
public class LastModifyTime {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            FileStatus[] files = fs.listStatus(new Path(HadoopConstant.UserPath.IN.getValue()));
            for (FileStatus file : files) {
                System.out.println(file.getPath() + "　:　" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(file.getModificationTime())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
