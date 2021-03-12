import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FirDriver
{
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, IOException
    {

        Configuration conf=new Configuration();
        //获取job对象
        Job job=Job.getInstance(conf);

        //设置jar储存的位置
        job.setJarByClass(FirDriver.class);

        //关联map和reduce类
        job.setMapperClass(FirMapper.class);
        job.setReducerClass(FirReducer.class);

        //设置map阶段输出数据的key和value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        //设置最终数据输出key和value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //设置输入路径和输出路径
        FileInputFormat.setInputPaths(job,new Path("data/friends.txt"));
        FileOutputFormat.setOutputPath(job,new Path("data/result"));

        //提交job
//        job.submit();
        boolean result=job.waitForCompletion(true);
        System.exit(result?0:1);
    }
}
