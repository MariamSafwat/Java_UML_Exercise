import java.util.*;

public class JobsDataService {
    public JobsDataService() {

    }
    public void FilterJobsByTitle(List<JobDetails> jobs){

        // create map that holds job titles as keys and their popularity as values
        Map<String, Integer> titlesPop = new HashMap<>();
        for (int i=0; i< jobs.size(); i++){
            if (!(titlesPop.containsKey(jobs.get(i).title))){
                int count = 1;
                // if title is not found loop over rest of jobs and count its freq then added it as value
                for(int j = i+1; j < jobs.size(); j++){
                    if(jobs.get(i).title.equals(jobs.get(j).title)){
                        count ++;
                    }
                }

                titlesPop.put(jobs.get(i).title, count);
            }


        }
        System.out.println("Job Titles and popularity:");
        System.out.println(titlesPop);


    }

    public void FilterJobsByCountry(List <JobDetails> jobs) {
        // create map that holds country as keys and job demands as values
        Map<String, Integer> countryPop = new HashMap<>();

        for (int i=0; i< jobs.size(); i++){
            if (!(countryPop.containsKey(jobs.get(i).country))){
                int count = 1;
                // if country is not found loop over rest of jobs and count jobs in this country then added it as value
                for(int j = i+1; j < jobs.size(); j++){
                    if(jobs.get(i).country.equals(jobs.get(j).country)){
                        count ++;
                    }
                }

                countryPop.put(jobs.get(i).country, count);
            }
        }
        System.out.println("list of Country and Job demand :");
        System.out.println(countryPop);

    }
    public void FilterJobsByLevel(List <JobDetails> jobs) {
        // create map that holds level as keys and job demands as values
        Map<String, Integer> levelPop = new HashMap<>();

        for (int i=0; i< jobs.size(); i++){
            if (!(levelPop.containsKey(jobs.get(i).level))){
                int count = 1;
                // if level is not found loop over rest of jobs and count jobs with same level then add it as value
                for(int j = i+1; j < jobs.size(); j++){
                    if(jobs.get(i).level.equals(jobs.get(j).level)){
                        count ++;
                    }
                }
                levelPop.put(jobs.get(i).level, count);
            }
        }
        System.out.println("list of Level and popularity :");
        System.out.println(levelPop);

    }

    public LinkedHashMap<String, Long> sortMap(Map<String, Long> map){
        // Create a list from elements of HashMap
        List<Map.Entry<String, Long> > list =
                new LinkedList<Map.Entry<String, Long> >(map.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Long> >() {
            public int compare(Map.Entry<String, Long> o1,
                               Map.Entry<String, Long> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        // put data from sorted list to hashmap
        LinkedHashMap<String, Long> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Long> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return  temp;
    }
    public void FilterJobsByYearsExp(List <JobDetails> jobs){
        // create map that holds level as keys and job demands as values
        Map<String, Long> yearsExpPop = new HashMap<>();

        for (int i=0; i< jobs.size(); i++){
            if (!(yearsExpPop.containsKey(jobs.get(i).yearsExp))){
                int count = 1;
                // if level is not found loop over rest of jobs and count jobs with same level then add it as value
                for(int j = i+1; j < jobs.size(); j++){
                    if(jobs.get(i).yearsExp.equals(jobs.get(j).yearsExp)){
                        count ++;
                    }
                }
                yearsExpPop.put(jobs.get(i).yearsExp, (long) count);
            }
        }
        System.out.println("sorted list of YearsExp and popularity :");
        //System.out.println(yearsExpPop);
        System.out.println(sortMap(yearsExpPop));
    }


}
