/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.applications;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;

import com.android.settings.R;

public class LinearColorPreference extends Preference {
    float mRedRatio;
    float mYellowRatio;
    float mGreenRatio;
    int mRedColor = 0xffaa5030;
    int mYellowColor = 0xffaaaa30;
    int mGreenColor = 0xff30aa50;
    int mColoredRegions = LinearColorBar.REGION_ALL;
    LinearColorBar.OnRegionTappedListener mOnRegionTappedListener;

    public LinearColorPreference(Context context) {
        super(context);
        setLayoutResource(R.layout.preference_linearcolor);
    }

    public void setRatios(float red, float yellow, float green) {
        mRedRatio = red;
        mYellowRatio = yellow;
        mGreenRatio = green;
        notifyChanged();
    }

    public void setColors(int red, int yellow, int green) {
        mRedColor = red;
        mYellowColor = yellow;
        mGreenColor = green;
        notifyChanged();
    }

    public void setOnRegionTappedListener(LinearColorBar.OnRegionTappedListener listener) {
        mOnRegionTappedListener = listener;
        notifyChanged();
    }

    public void setColoredRegions(int regions) {
        mColoredRegions = regions;
        notifyChanged();
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder view) {
        super.onBindViewHolder(view);

        LinearColorBar colors = (LinearColorBar)view.findViewById(
                R.id.linear_color_bar);
        colors.setShowIndicator(false);
        colors.setColors(mRedColor, mYellowColor, mGreenColor);
        colors.setRatios(mRedRatio, mYellowRatio, mGreenRatio);
        colors.setColoredRegions(mColoredRegions);
        colors.setOnRegionTappedListener(mOnRegionTappedListener);
    }
}
