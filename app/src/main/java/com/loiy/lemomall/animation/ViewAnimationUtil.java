package com.loiy.lemomall.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class ViewAnimationUtil {
    /**
     * Animate the view to become visible, using the default duration and interpolator.
     *
     * @param view The view to animate.
     */
    public static void animateViewVisible(final View view) {
        animateViewVisible(view, 200, null);
    }

    /**
     * Animate the view to become visible, with a specified duration and interpolator.
     *
     * @param view The view to animate.
     * @param duration The duration of the animation in milliseconds.
     * @param listener A listener to be notified when the animation completes.
     */
    public static void animateViewVisible(final View view, int duration, final AnimatorListenerAdapter listener) {
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0f);
        view.animate()
                .alpha(1f)
                .setDuration(duration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (listener != null) {
                            listener.onAnimationEnd(animation);
                        }
                    }
                });
    }

    /**
     * Animate the view to become gone, using the default duration and interpolator.
     *
     * @param view The view to animate.
     */
    public static void animateViewInvisible(final View view) {
        animateViewInvisible(view, 200, null);
    }

    /**
     * Animate the view to become gone, with a specified duration and interpolator.
     *
     * @param view The view to animate.
     * @param duration The duration of the animation in milliseconds.
     * @param listener A listener to be notified when the animation completes.
     */
    public static void animateViewInvisible(final View view, int duration, final AnimatorListenerAdapter listener) {
        view.animate()
                .alpha(0f)
                .setDuration(duration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        view.setVisibility(View.INVISIBLE);
                        view.setAlpha(1f);
                        if (listener != null) {
                            listener.onAnimationEnd(animation);
                        }
                    }
                });
    }

    public static void animateViewInvisible(final View view,  final AnimatorListenerAdapter listener) {
        view.setVisibility(View.INVISIBLE);
    }
}
