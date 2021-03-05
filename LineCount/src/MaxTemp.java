import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.fs.Path;

public class MaxTemp {

	public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

		public void map(LongWritable arg0, Text value, OutputCollector<Text, IntWritable> output, Reporter arg3)
				throws IOException {
			String line = value.toString();
			String col[] = line.split(",");
			String te = col[3];
			String year = col[2];
			int temp = Integer.parseInt(te);
			output.collect(new Text(year), new IntWritable(temp));
		}
	}
	
	public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{

		public void reduce(Text arg0, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output,
				Reporter arg3) throws IOException {
			int temp_max = 0;
			while(values.hasNext()) {
				int cur = values.next().get();
				if(temp_max < cur)
					temp_max = cur;
			}
			output.collect(arg0, new IntWritable(temp_max));
		}
	}
	
	public static void main(String[] args)throws IOException{
		JobConf conf = new JobConf(MaxTemp.class);
		
		conf.setJobName("Maximum Temperature");
		
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
		conf.setMapperClass(Map.class);
		conf.setReducerClass(Reduce.class);
		
		Path ip = new Path(args[0]);
		Path op = new Path(args[1]);
		
		FileInputFormat.addInputPath(conf, ip);
		FileOutputFormat.setOutputPath(conf, op);
		
		JobClient.runJob(conf);
	}
}
