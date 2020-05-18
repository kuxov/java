public class student
{
    public int num;
    public int labs;
    public String subject;

    student(int num)
    {
        this.num = num;
        this.labs = data.labs[(int) (Math.random() * data.subjects.length)];
        this.subject = data.subjects[(int) (Math.random() * data.subjects.length)];
    }

    public void decLabs(int i)
    {
        this.labs = labs - i;
    }

    @Override
    public String toString()
    {
        return ("студент: " + num + " | кол-во лаб: " + labs + " | предмет: " + subject);
    }
}