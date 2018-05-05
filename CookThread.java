import java.util.List;

public class CookThread extends Thread
{
    private List<Food> foodToBeCooked;
    private Food current;
    private List<Food> foodChefMikeFinishedCooking;


    public CookThread(List<Food> foodToBeCooked)
    {
        this.foodToBeCooked = foodToBeCooked;
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


    public List<Food> chefMikeCooking()
    {
        if(!allFoodFinished())
        {
            broadcastChefReady();
            getFirstFood();
            broadcastChefStart();
        }


        this.foodChefMikeFinishedCooking.add(this.current);
        return this.foodChefMikeFinishedCooking;

    }


    public Thread waitingForFoodFinishedCooking()
    {
        try {
            Thread.sleep(1000*(this.current.getCookTime()));
        } catch (InterruptedException ex){}
    }









}
