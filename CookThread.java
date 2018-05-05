import java.util.List;

public class CookThread implements Runnable
{
    private List<Food> foodToBeCooked;
    private Food current;
    private List<Food> foodChefMikeFinishedCooking;
    //private Thread cooker;

    public CookThread(List<Food> foodToBeCooked)
    {
        this.foodToBeCooked = foodToBeCooked;
       // this.cooker = cooker;
        //this.cooker.start();
    }

    public void getFirstFood()
    {
        this.current = this.foodToBeCooked.get(0);
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
            getFirstFood();
            broadcastChefStart();
            waitingForFoodFinishedCooking();
            broadcastChefFinishedCurrent();
            this.foodChefMikeFinishedCooking.add(this.current);
            this.foodToBeCooked.remove(0);
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
