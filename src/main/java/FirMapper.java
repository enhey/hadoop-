import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FirMapper extends Mapper<LongWritable, Text,Text, Text>
{
    Text k=new Text();
    Text v=new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
    {
        String line = value.toString();
        if(line.length()<3){
            return;
        }
        String[] split = line.split(":");
        String host=split[0];
        v.set(host);
        String[] friend_list = split[1].split(",");
        for (String friend:friend_list){
            k.set(friend);
            context.write(k,v);
        }
    }
}
