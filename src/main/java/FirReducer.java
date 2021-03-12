import org.apache.commons.lang.text.StrBuilder;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FirReducer extends Reducer<Text,Text,Text,Text>
{
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
    {
        StrBuilder line=new StrBuilder();
        for (Text value:values){
            line.append(value).append(",");
        }
        context.write(key,new Text(line.toString()));
    }
}
