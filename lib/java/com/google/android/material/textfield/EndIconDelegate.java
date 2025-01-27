/*
 * Copyright (C) 2019 The Android Open Source Project
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

package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout.BoxBackgroundMode;

/**
 * End icon delegate abstract class.
 *
 * Each end icon delegate class that extends this class will provide the default configuration for
 * a specific {@link TextInputLayout} {@link TextInputLayout.EndIconMode}.
 */
abstract class EndIconDelegate {

  final TextInputLayout textInputLayout;
  final EndCompoundLayout endLayout;
  final Context context;
  final CheckableImageButton endIconView;

  @DrawableRes
  final int customEndIcon;

  EndIconDelegate(@NonNull EndCompoundLayout endLayout, @DrawableRes int customEndIcon) {
    this.textInputLayout = endLayout.textInputLayout;
    this.endLayout = endLayout;
    this.context = endLayout.getContext();
    this.endIconView = endLayout.getEndIconView();
    this.customEndIcon = customEndIcon;
  }

  /**
   * Default configurations for the specified end icon.
   */
  abstract void initialize();

  /**
   * Whether the end icon should be tinted with the error color when the {@link TextInputLayout} is
   * in error mode.
   */
  boolean shouldTintIconOnError() {
    return false;
  }

  /**
   * Whether the {@link BoxBackgroundMode} of the {@link TextInputLayout} is supported.
   *
   * @param boxBackgroundMode the text input's box background mode
   */
  boolean isBoxBackgroundModeSupported(@BoxBackgroundMode int boxBackgroundMode) {
    return true;
  }

  /**
   * This method should be implemented if the icon needs special handling of it's visibility
   * behavior when there is a suffix being displayed.
   *
   * @param visible whether the icon should be set to visible
   */
  void onSuffixVisibilityChanged(boolean visible) {}
}
