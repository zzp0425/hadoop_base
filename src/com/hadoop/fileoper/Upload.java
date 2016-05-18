package com.hadoop.fileoper;

import com.hadoop.constant.HadoopConstant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Desc 上传文件到hadoop
 * Created by zzp
 * on 2016/5/17.20:24
 */
public class Upload {

    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            Path src = new Path("E:\\银监会文件交换服务\\最高人民法院\\Download\\CXQQF126H1015134010010000AWYHYH00032920160509000001.zip201605171140001");
            Path des = new Path(HadoopConstant.UserPath.IN.getValue());

            fs.copyFromLocalFile(src, des);

            System.out.println("UploadTo：" + conf.get("fs.default.name"));
            FileStatus[] files = fs.listStatus(des);
            for (FileStatus file : files) {
                System.out.println(file.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
