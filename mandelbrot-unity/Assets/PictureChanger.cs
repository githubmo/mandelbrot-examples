using System;
using System.Collections;
using System.Collections.Generic;
using System.Numerics;
using DefaultNamespace;
using UnityEngine;

public class PictureChanger : MonoBehaviour
{
    private Texture2D _texture;
    private Color[] _colors = new Color[] { Color.red, Color.blue, Color.yellow, Color.green, Color.white, Color. grey};
    
    // Start is called before the first frame update
    void Start()
    {
        _texture = GetComponent<SpriteRenderer>().sprite.texture;
        for (int x = 0; x < _texture.width; x++)
        {
            for (int y = 0; y < _texture.height; y++)
            {
                ColorPosition(x, y);
            }
        }
        _texture.Apply();
    }

    private void ColorPosition(int x, int y)
    {
        var complexNumber = new Complex(x / (_texture.width / 4.0) - 2.0, y / (_texture.height / 4.0) - 2.0);

        var iter = Mandelbrot.Compute(complexNumber);
        // _texture.SetPixel(x, y, Color.blue);
        if (iter >= Mandelbrot.MaxIter)
        {
            _texture.SetPixel(x, y, Color.black);
        
        }
        else
        {
            var colorIndex = Math.Min(5, iter/6);
            var color = _colors[colorIndex];
            _texture.SetPixel(x, y, color);
        }

    }
}
