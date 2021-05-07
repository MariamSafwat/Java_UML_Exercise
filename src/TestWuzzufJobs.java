import java.util.List;

public class TestWuzzufJobs {
    public TestWuzzufJobs(){}

    public void test(){
        IO jobsIO = new IO();
        List<JobDetails> jobs = jobsIO.ReadCSVFile("src/Wuzzuf_Jobs.csv");

        JobsDataService jobsServices = new JobsDataService();
        jobsServices.FilterJobsByCountry(jobs);
        jobsServices.FilterJobsByLevel(jobs);
        jobsServices.FilterJobsByTitle(jobs);
        jobsServices.FilterJobsByYearsExp(jobs);

    }
}
