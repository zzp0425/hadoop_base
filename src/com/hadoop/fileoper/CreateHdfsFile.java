package com.hadoop.fileoper;

import com.hadoop.constant.HadoopConstant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Desc 创建HDFS文件
 * Created by zzp
 * on 2016/5/17.22:31
 */
public class CreateHdfsFile {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            byte[] bytes = "Hello zzp!".getBytes();
            Path des = new Path(HadoopConstant.UserPath.IN.getValue() + "createTest.txt");
            FSDataOutputStream fdos = fs.create(des);
            fdos.write(bytes, 0, bytes.length);

            FileStatus[] files = fs.listStatus(new Path(HadoopConstant.UserPath.IN.getValue()));
            for (FileStatus file : files) {
                System.out.println(file.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
