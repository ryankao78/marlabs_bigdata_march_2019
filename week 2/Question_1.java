import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.util.*;

public static class MyMap extends Mapper<LongWritable,Text,Text,Text>
{
  public void map(LongWritable key, Text value, Context context)
  {
     try{
        String[] str = value.toString().split("\t", -3);
        String gender=str[2];
        context.write(new Text(gender), new Text(value));
     }
     catch(Exception e)
     {
        System.out.println(e.getMessage());
     }
  }
}

public static class MyReduce extends Reducer<Text,Text,Text,IntWritable>
{
  public int max = -1;
  public void reduce(Text key, Iterable <Text> values, Context context) throws IOException, InterruptedException
  {
     max = -1;

     for (Text val : values)
     {
        String [] str = val.toString().split("\t", -3);
        if(Integer.parseInt(str[3])>max)
        max=Integer.parseInt(str[3]);
     }

     context.write(new Text(key), new IntWritable(max));
  }
}
