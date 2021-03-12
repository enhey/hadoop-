import org.apache.commons.lang.text.StrBuilder;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.mortbay.io.Buffers;

import java.awt.image.BufferStrategy;
import java.io.IOException;

public class SecMapper extends Mapper<LongWritable, Text, Text, Text>
{
    Text k = new Text();
    Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
    {
        String line = value.toString();
        String[] split = line.split("\t");
        String host = split[0];
        v.set(host);
        String friends = split[1];
        String[] friend_list = friends.split(",");

        for (int i = 0; i < friend_list.length; i++)
        {
            for (int j = i + 1; j < friend_list.length; j++)
            {
                StringBuilder ke = new StringBuilder();
                if (friend_list[i].compareTo(friend_list[j]) < 0)
                {
                    ke.append(friend_list[i]).append("-").append(friend_list[j]);
                } else
                {
                    ke.append(friend_list[j]).append("-").append(friend_list[i]);
                }
                k.set(ke.toString());
                context.write(k, v);
            }
        }
    }
}
