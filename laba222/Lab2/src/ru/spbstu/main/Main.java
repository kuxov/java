package ru.spbstu.main;

import java.util.concurrent.ThreadLocalRandom;
import ru.spbstu.main.shapes.*;

//import java.awt.*;

public class Main
{

    private static int randInt(int lower, int bound)
    {
        return ThreadLocalRandom.current().nextInt(lower, bound);
    }

    public static void main(String[] args)
    {
        Shape[] shapes = new Shape[10];
        for(int i=0; i<10; i++)
        {
            int n = (int) (Math.random()*3);
            switch(n)
            {
                case 0: {
                    Dot center = new Dot(randInt(1, 51), randInt(1, 51));
                    shapes[i] = new Circle(randInt(1, 51), center);
                }
                    break;
                case 1:
                    shapes[i] = new Rectangle(randInt(1, 51), randInt(1, 51), randInt(0, 360));
                    break;
                default:
                {
                    Dot dot1 = new Dot(randInt(1, 51), randInt(1, 51));
                    Dot dot2 = new Dot(randInt(1, 51), randInt(1, 51));
                    Dot dot3 = new Dot(randInt(1, 51), randInt(1, 51));
                    shapes[i] = new Triangle(new Dot[]{dot1, dot2, dot3}, randInt(0, 360));
                }
            }
        }
        for (Shape shape : shapes)
        {
            System.out.println(shape.print());
        }
        System.out.println("\n\nShape with max area is:");
        System.out.println(findMaxAreaShape(shapes).print());
    }

    public static Shape findMaxAreaShape(Shape[] shapes)
    {
        float[] areas = new float[10];
        Float max = shapes[0].getArea();
        int number = 0;
        for(int i = 0; i < shapes.length; i++)
        {
            areas[i] = shapes[i].getArea();
            if(max < areas[i])
            {
                max = areas[i];
                number = i;
            }
        }
        return shapes[number];
    }
}
