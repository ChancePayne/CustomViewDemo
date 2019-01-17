package com.lambdaschool.customviewdemo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lambdaschool.customviewdemo.R;

public class BasicCustomView extends View {

    protected Rect rectangle1, rectangle2;
    protected Paint paint1, paint2;
    protected int backColor;
    protected int frontColor;
    protected float sizeVertical;
    protected float sizeHorizontal;

    /**
     * Simple constructor to use when creating a view from code.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public BasicCustomView(Context context) {
        super(context);
        init(null);
    }

    /**
     * Constructor that is called when inflating a view from XML. This is called
     * when a view is being constructed from an XML file, supplying attributes
     * that were specified in the XML file. This version uses a default style of
     * 0, so the only attribute values applied are those in the Context's Theme
     * and the given AttributeSet.
     *
     * <p>
     * The method onFinishInflate() will be called after all children have been
     * added.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     * @see View(Context, AttributeSet, int)
     */
    public BasicCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    /**
     * Perform inflation from XML and apply a class-specific base style from a
     * theme attribute. This constructor of View allows subclasses to use their
     * own base style when they are inflating. For example, a Button class's
     * constructor would call this version of the super class constructor and
     * supply <code>R.attr.buttonStyle</code> for <var>defStyleAttr</var>; this
     * allows the theme's button style to modify all of the base view attributes
     * (in particular its background) as well as the Button class's attributes.
     *
     * @param context      The Context the view is running in, through which it can
     *                     access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     *                     reference to a style resource that supplies default values for
     *                     the view. Can be 0 to not look for defaults.
     * @see View(Context, AttributeSet)
     */
    public BasicCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    /**
     * Perform inflation from XML and apply a class-specific base style from a
     * theme attribute or style resource. This constructor of View allows
     * subclasses to use their own base style when they are inflating.
     * <p>
     * When determining the final value of a particular attribute, there are
     * four inputs that come into play:
     * <ol>
     * <li>Any attribute values in the given AttributeSet.
     * <li>The style resource specified in the AttributeSet (named "style").
     * <li>The default style specified by <var>defStyleAttr</var>.
     * <li>The default style specified by <var>defStyleRes</var>.
     * <li>The base values in this theme.
     * </ol>
     * <p>
     * Each of these inputs is considered in-order, with the first listed taking
     * precedence over the following ones. In other words, if in the
     * AttributeSet you have supplied <code>&lt;Button * textColor="#ff000000"&gt;</code>
     * , then the button's text will <em>always</em> be black, regardless of
     * what is specified in any of the styles.
     *
     * @param context      The Context the view is running in, through which it can
     *                     access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     *                     reference to a style resource that supplies default values for
     *                     the view. Can be 0 to not look for defaults.
     * @param defStyleRes  A resource identifier of a style resource that
     *                     supplies default values for the view, used only if
     *                     defStyleAttr is 0 or can not be found in the theme. Can be 0
     *                     to not look for defaults.
     * @see View(Context, AttributeSet, int)
     */
    public BasicCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    protected void init(AttributeSet attrs) {
        rectangle1 = new Rect();
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectangle2 = new Rect();
        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(
                    attrs,
                    R.styleable.BasicCustomView);
            backColor = typedArray.getResourceId(R.styleable.BasicCustomView_back_color, R.color.colorPrimaryDark);
            frontColor = typedArray.getResourceId(R.styleable.BasicCustomView_front_color, R.color.colorAccent);
            sizeVertical = typedArray.getInt(R.styleable.BasicCustomView_size_vertical, 100) / 100f;
            sizeHorizontal = typedArray.getInt(R.styleable.BasicCustomView_size_horizontal, 100) / 100f;
        }

    }

    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width  = getWidth();
        int height = getHeight();

        canvas.rotate(90, width / 2f, height / 2f);

        rectangle1.top = (int) (0.1 * height * sizeVertical);
        rectangle1.bottom = (int) (0.9 * height * sizeVertical);
        rectangle1.left = (int) (0.1 * width * sizeHorizontal);
        rectangle1.right = (int) (0.9 * width * sizeHorizontal);

        rectangle2.top = (int) (0.25 * height * sizeVertical);
        rectangle2.bottom = (int) (0.75 * height * sizeVertical);
        rectangle2.left = (int) (0.25 * width * sizeHorizontal);
        rectangle2.right = (int) (0.75 * width * sizeHorizontal);

        paint1.setColor(getResources().getColor(backColor));
        paint2.setColor(getResources().getColor(frontColor));

        canvas.drawRect(rectangle1, paint1);
        canvas.drawRect(rectangle2, paint2);
    }
}
