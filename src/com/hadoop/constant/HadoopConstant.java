package com.hadoop.constant;

/**
 * Desc
 * Created by zzp
 * on 2016/5/17.22:36
 */
public class HadoopConstant {
    public enum UserPath{
        ROOT("/user/zzp/"),
        IN("/user/zzp/in/"),
        OUT("/user/zzp/out/");
        private String value;
        UserPath(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
    }
}
