package com.hwy.round;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;

/**
 * 作者: hewenyu
 * 日期: 2018/12/17 20:58
 * 说明: 带数字提示的ImageView
 */
public class BadgeImageView extends RoundImageView {

    private Paint mPaint;

    /**
     * badge显示的数值
     */
    private int mBadgeText = 0;

    /**
     * badge文本的颜色
     */
    private int mBadgeTextColor = Color.WHITE;

    /**
     * badge文本的大小
     */
    private int mBadgeTextSize = 10;

    /**
     * badge的半径
     */
    private int mBadgeRadius = 10;

    /**
     * badge的颜色
     */
    private int mBadgeColor = Color.RED;

    /**
     * badge x轴方向上的偏移量
     */
    private int mBadgeOffsetX = 0;

    /**
     * badge y 轴上的偏移量
     */
    private int mBadgeOffsetY = 0;

    /**
     * badge 显示的最大数值
     */
    private int mBadgeMaxValue = 99;

    /**
     * badge 显示的类型
     */
    private BadgeType mBadgeType = BadgeType.DOT;

    /**
     * badge 超过最大数值时显示的文本
     */
    private String mBadgeOverflow = "99+";

    private int mWidth, mHeight;

    public BadgeImageView(Context context) {
        super(context);
        initBadge();
    }

    public BadgeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BadgeImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.BadgeImageView);
        mBadgeText = array.getInt(R.styleable.BadgeImageView_badgeText, mBadgeText);
        mBadgeTextSize = array.getDimensionPixelSize(R.styleable.BadgeImageView_badgeTextSize, mBadgeTextSize);
        mBadgeTextColor = array.getColor(R.styleable.BadgeImageView_badgeTextColor, mBadgeTextColor);
        mBadgeRadius = array.getDimensionPixelSize(R.styleable.BadgeImageView_badgeRadius, mBadgeRadius);
        mBadgeColor = array.getColor(R.styleable.BadgeImageView_badgeColor, mBadgeColor);
        mBadgeOffsetX = array.getDimensionPixelSize(R.styleable.BadgeImageView_badgeOffsetX, mBadgeOffsetX);
        mBadgeOffsetY = array.getDimensionPixelSize(R.styleable.BadgeImageView_badgeOffsetY, mBadgeOffsetY);
        mBadgeMaxValue = array.getInt(R.styleable.BadgeImageView_badgeMaxValue, mBadgeMaxValue);
        mBadgeOverflow = TextUtils.isEmpty(array.getString(R.styleable.BadgeImageView_badgeOverflow)) ? mBadgeOverflow : array.getString(R.styleable.BadgeImageView_badgeOverflow);
        mBadgeType = BadgeType.parseType(array.getInt(R.styleable.BadgeImageView_badgeType, BadgeType.DOT.getTypeValue()));
        array.recycle();

        initBadge();
    }


    private void initBadge() {
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextAlign(Paint.Align.CENTER);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBadgeText <= 0) {
            return;
        }

        int cx = mWidth - mBadgeRadius + mBadgeOffsetX;
        int cy = mBadgeRadius + mBadgeOffsetY;

        mPaint.setColor(mBadgeColor);
        canvas.drawCircle(cx, cy, mBadgeRadius, mPaint);

        if (mBadgeType == BadgeType.DOT) {
            return;
        }

        mPaint.setColor(mBadgeTextColor);
        mPaint.setTextSize(mBadgeTextSize);
        String tempBadge = mBadgeText > mBadgeMaxValue ? mBadgeOverflow : mBadgeText + "";
        canvas.drawText(tempBadge, cx, cy + calculateBaseLine(mPaint), mPaint);

    }

    // region ------------ get/set ---------

    public void setBadgeText(int badgeText) {
        this.mBadgeText = badgeText;
        invalidate();
    }

    public int getBadgeText() {
        return this.mBadgeText;
    }

    public void setBadgeTextSize(int textSize) {
        this.mBadgeTextSize = textSize;
        invalidate();
    }

    public int getBadgeTextSize() {
        return this.mBadgeTextSize;
    }

    public void setBadgeTextColor(int textColor) {
        this.mBadgeTextColor = textColor;
        invalidate();
    }

    public int getBadgeTextColor() {
        return this.mBadgeTextColor;
    }

    public void setBadgeRadius(int radius) {
        this.mBadgeRadius = radius;
        invalidate();
    }

    public int getBadgeRadius() {
        return this.mBadgeRadius;
    }

    public void setBadgeColor(int badgeColor) {
        this.mBadgeColor = badgeColor;
        invalidate();
    }

    public int getBadgeColor() {
        return this.mBadgeColor;
    }

    public void setBadgeOverflow(String overflow) {
        this.mBadgeOverflow = overflow;
        invalidate();
    }

    public String getBadgeOverflow() {
        return this.mBadgeOverflow;
    }

    public void setBadgeType(BadgeType type) {
        this.mBadgeType = type;
        invalidate();
    }

    public BadgeType getBadgeType() {
        return this.mBadgeType;
    }

    public void setBadgeMaxValue(int maxValue) {
        this.mBadgeMaxValue = maxValue;
        invalidate();
    }

    public int getBadgeMaxValue() {
        return this.mBadgeMaxValue;
    }

    public void setBadgeOffsetX(int offsetX) {
        this.mBadgeOffsetX = offsetX;
        invalidate();
    }

    public int getBadgeOffsetX() {
        return this.mBadgeOffsetX;
    }

    public void setBadgeOffsetY(int offsetY) {
        this.mBadgeOffsetY = offsetY;
        invalidate();
    }

    public int getBadgeOffsetY() {
        return this.mBadgeOffsetY;
    }

    // endregion ----------------------------

    // region ------------ 工具方法 ----------

    private int calculateBaseLine(Paint paint) {
        Paint.FontMetrics metrics = paint.getFontMetrics();
        return (int) (Math.abs(metrics.top + metrics.bottom) / 2);
    }

    // endregion --------------------------------

    // region ----------- 徽章显示的类型 ----------

    public enum BadgeType {
        DOT(0), // 红点
        VALUE(1);   // 数字

        private int typeValue;

        BadgeType(int typeValue) {
            this.typeValue = typeValue;
        }

        public int getTypeValue() {
            return this.typeValue;
        }

        public static BadgeType parseType(int type) {
            BadgeType[] types = BadgeType.values();
            for (BadgeType badgeType : types) {
                if (badgeType.typeValue == type) {
                    return badgeType;
                }
            }
            return DOT;
        }
    }

    // endregion ---------------------------------------

}
