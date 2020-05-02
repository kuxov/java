public class student
{
    private type type;
    private int load;
    private int progress;

    public student(type t,int l)
    {
        setLoad(l);
        setType(t);
    }

    public boolean checkProgress()
    {
        return getProgress() < getLoad();
    }

    public void incProgress(int val)
    {
        int i = getProgress() + val;
        setProgress(i);
    }

    public int getLoad()
    {
        return load;
    }

    public type getType()
    {
        return type;
    }

    public int getProgress()
    {
        return progress;
    }

    public void setLoad(int load)
    {
        this.load = load;
    }

    public void setType(type type)
    {
        this.type = type;
    }

    public void setProgress(int progress)
    {
        this.progress = progress;
    }
}
