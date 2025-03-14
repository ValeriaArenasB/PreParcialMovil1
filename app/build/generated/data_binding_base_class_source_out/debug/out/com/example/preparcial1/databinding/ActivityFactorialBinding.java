// Generated by view binder compiler. Do not edit!
package com.example.preparcial1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.preparcial1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFactorialBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button enter;

  @NonNull
  public final ConstraintLayout listView;

  @NonNull
  public final EditText numero;

  private ActivityFactorialBinding(@NonNull ConstraintLayout rootView, @NonNull Button enter,
      @NonNull ConstraintLayout listView, @NonNull EditText numero) {
    this.rootView = rootView;
    this.enter = enter;
    this.listView = listView;
    this.numero = numero;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFactorialBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFactorialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_factorial, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFactorialBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.enter;
      Button enter = ViewBindings.findChildViewById(rootView, id);
      if (enter == null) {
        break missingId;
      }

      ConstraintLayout listView = (ConstraintLayout) rootView;

      id = R.id.numero;
      EditText numero = ViewBindings.findChildViewById(rootView, id);
      if (numero == null) {
        break missingId;
      }

      return new ActivityFactorialBinding((ConstraintLayout) rootView, enter, listView, numero);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
