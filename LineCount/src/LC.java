import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.fs.Path;

public class LC {

	public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
		
		public IntWritable one = new IntWritable(1);
		public Text word = new Text("Total number of lines");
		
		public void map(LongWritable arg0, Text arg1, OutputCollector<Text, IntWritable> output, Reporter arg3)
				throws IOException {
			output.collect(word, one);
			
		}
	}
	
	public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{

		public void reduce(Text arg0, Iterator<IntWritable> arg1, OutputCollector<Text, IntWritable> output,
				Reporter arg3) throws IOException {
			int sum = 0;
			while(arg1.hasNext()) {
				sum += arg1.next().get();
			}
			output.collect(arg0, new IntWritable(sum));
		}
	}
	
	public static void main(String[] args)throws IOException {
		JobConf conf = new JobConf(LC.class);
		
		conf.setJobName("Line Count");
		
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
