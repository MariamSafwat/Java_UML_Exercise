
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class IO {

    public IO() {
    }

    public List<JobDetails> ReadCSVFile(String fileName) {
        List<JobDetails> jobs = new ArrayList<>();

        // create an instance of BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // read the first line from the text file which will be head column
            //Stream<String> lines = br.lines();
            String line = br.readLine();
            // read first line
            if (line != null) {
                line = br.readLine(); // the first real data
            }
            // loop until all lines are read
            String[] values;
            while (line != null) {
                //System.out.println("the line " + line);
                // use string.split to load a string array with the values from each line of the file

                values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                // adding into ArrayList
                JobDetails job = createJob(values);
                jobs.add(job);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return jobs;
    }

    public JobDetails createJob(String[] metadata) {

        String title = metadata[0];
        String company = metadata[1];
        String location = metadata[2];
        String type = metadata[3];
        String level = metadata[4];
        String yearsExp = metadata[5];
        String country = metadata[6];
        String skills = metadata[7];

        //System.out.println("skills: "+ skills);
        // create and return JobDetails of this metadata
        return new JobDetails(title, company, location, type, level, yearsExp, country, skills);
    }

}
