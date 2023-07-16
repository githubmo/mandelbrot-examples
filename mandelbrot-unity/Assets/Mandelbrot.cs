using System;
using System.Numerics;

namespace DefaultNamespace
{
    public class Mandelbrot
    {
        public static readonly int MaxIter = 50;
        
        public static int Compute(Complex n)
        {
            return Compute(n, n, 1);
        }

        private static int Compute(Complex n, Complex c, int iter)
        {
            if (iter >= MaxIter) return MaxIter;
            if (n.Magnitude >= 2) return iter;
            var next = n * n + c;
            return Compute(next, c, iter + 1);
        }
    }
}
