package ru.spbstu.main.shapes;

public class Triangle implements Polygon
{
    public static void main(String[] args)
    {
        Dot dot1 = new Dot(5, 6);
        Dot dot2 = new Dot(8, 10);
        Dot dot3 = new Dot(3, -1);
        Shape tr = new Triangle(new Dot[]{dot1, dot2, dot3}, 20);
        System.out.println(tr.print());
    }

    public Triangle(Dot[] vert,  int angle)
    {
        if(vert.length != 3)
        {
            throw new IllegalArgumentException("Triangle must have 3 vertixes");
        }
        if((angle < 0) || (angle > 360))
        {
            throw new IllegalArgumentException("Angle  must be in [0, 360] range");
        }
        vertixes_ = vert;
        angle_ = angle;
    }

    @Override
    public float getArea()
    {
        float[] sizeLength = new float[3];
        for(int i = 0; i < 2; i++)
        {
            sizeLength[i] = getLength(vertixes_[i], vertixes_[i + 1]);
        }
        sizeLength[2] = getLength(vertixes_[2], vertixes_[0]);

        float p = getPerimeter() / 2;

        float area = 1;
        for(int i = 0; i < 3; i++)
        {
            area *= p - sizeLength[i];
        }
        return (float)Math.sqrt(p * area);
    }

    public float getPerimeter()
    {
        float[] sizeLength = new float[3];
        for(int i = 0; i < 2; i++)
        {
            sizeLength[i] = getLength(vertixes_[i], vertixes_[i + 1]);
        }
        sizeLength[2] = getLength(vertixes_[2], vertixes_[0]);

        float p = 0;
        for(int i = 0; i < 3; i++)
        {
            p += sizeLength[i];
        }
        return p;
    }

    public int getRotation()
    {
        return angle_;
    }

    private float getLength(Dot a, Dot b)
    {
        return((float)Math.sqrt(pow2(a.getX() - b.getX()) + pow2(a.getY() - b.getY())));
    }

    private float pow2(float ex)
    {
        return (ex * ex);
    }

    @Override
    public String print() {
        return "Triangle (" + vertixes_[0].getX() + ", " + vertixes_[0].getY()
                +  "), (" + vertixes_[1].getX() + ", " + vertixes_[1].getY() +  "), ("
                + vertixes_[2].getX() + ", " + vertixes_[2].getY() +  ")" + ", area =  " + getArea();
    }

    private Dot[] vertixes_;
    private int angle_;
}
