// Generated by view binder compiler. Do not edit!
package com.example.preparcial1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.preparcial1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRandomGreetBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnVolver;

  @NonNull
  public final TextView tvGreeting;

  private ActivityRandomGreetBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnVolver,
      @NonNull TextView tvGreeting) {
    this.rootView = rootView;
    this.btnVolver = btnVolver;
    this.tvGreeting = tvGreeting;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRandomGreetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRandomGreetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_random_greet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRandomGreetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnVolver;
      Button btnVolver = ViewBindings.findChildViewById(rootView, id);
      if (btnVolver == null) {
        break missingId;
      }

      id = R.id.tvGreeting;
      TextView tvGreeting = ViewBindings.findChildViewById(rootView, id);
      if (tvGreeting == null) {
        break missingId;
      }

      return new ActivityRandomGreetBinding((ConstraintLayout) rootView, btnVolver, tvGreeting);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
