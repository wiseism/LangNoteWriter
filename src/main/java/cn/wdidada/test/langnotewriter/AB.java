package cn.wdidada.test.langnotewriter;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AB {
    public static void main(String[] args) throws Exception{
        AB ab = new AB();
        for(int i = 0;i<363;i++) {
            System.out.println(ab.dddv(i));
            System.out.println(ab.ddd(i));

            String dateStr = ab.ddd(i);
            String monthStr = ab.dddv(i);
            FileUtils.write(new File(monthStr+File.separator+dateStr+".md"),"# "+dateStr);
        }


//        FileUtils.write(new File("20210101.md"),"# 20210101");
    }

    public String ddd(int mount) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyyMMdd" );
        Calendar cal = Calendar.getInstance();
        cal.add( Calendar.DATE, mount );
        return dateFormat.format(cal.getTime());
    }

    public String dddv(int mount) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyyMM" );
        Calendar cal = Calendar.getInstance();
        cal.add( Calendar.DATE, mount );
        return dateFormat.format(cal.getTime());
    }
}
