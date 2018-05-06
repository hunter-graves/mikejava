import java.util.ArrayList;
import java.util.List;

public class CookThread implements Runnable
{
    private List<Food> foodToBeCooked = new ArrayList<>();
    private Food current;
    private List<Food> foodChefMikeFinishedCooking = new ArrayList<>();
    private int next = 0;
    //private Thread cooker;

    public CookThread(List<Food> foodToBeCooked)
    {
        this.foodToBeCooked = foodToBeCooked;
        //foodChefMikeFinishedCooking.size(this.foodToBeCooked.size())
       // this//.cooker = cooker;
        //this.cooker.start();
    }

    public void getFood(int next)
    {
        this.current = this.foodToBeCooked.get(next);
    }


    public void broadcastChefReady()
    {
        System.out.println("Chef Mike is ready");
    }

    public void broadcastChefStart()
    {
        System.out.println("Chef Mike is Starting: " + this.current.toString());
    }

    public void broadcastChefFinishedCurrent()
    {
        System.out.println("Chef Mike finished " + this.current.toString());
    }


    public void broadcastChefFinishedEverything()
    {
        System.out.println("Chef Mike finished cooking all of the food.");
    }


    public boolean allFoodFinished()
    {
        return this.foodToBeCooked.isEmpty();
    }

    @Override
    public void run()
    {

        if(!allFoodFinished())
        {
            broadcastChefReady();
            getFood(this.next);
            broadcastChefStart();
            waitingForFoodFinishedCooking();
            broadcastChefFinishedCurrent();
            this.foodChefMikeFinishedCooking.add(this.current);
            this.foodToBeCooked.remove(this.next);
            next++;
            run();

        }
        else
            broadcastChefFinishedEverything();
    }


    public void waitingForFoodFinishedCooking()
    {
        try {
            Thread.sleep(1000*(this.current.getCookTime()));
        } catch (InterruptedException ex)
            {
                System.out.println("There was a problem making the thread sleep for the cook duration!");
            }

    }

    public List<Food> completedListOfFood()
    {
        return this.foodChefMikeFinishedCooking;
    }









}
