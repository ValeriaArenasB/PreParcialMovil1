package com.example.preparcial1;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/example/preparcial1/TicTacToeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/preparcial1/databinding/ActivityTicTacToeBinding;", "gameOver", "", "jugadorActual", "", "tablero", "", "[[Ljava/lang/String;", "clickButton", "", "button", "Landroid/widget/Button;", "index", "", "iniciarTablero", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reiniciarJuego", "revisarGanador", "tableroLleno", "app_debug"})
public final class TicTacToeActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.preparcial1.databinding.ActivityTicTacToeBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String[][] tablero;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jugadorActual = "X";
    private boolean gameOver = false;
    
    public TicTacToeActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void iniciarTablero() {
    }
    
    private final void clickButton(android.widget.Button button, int index) {
    }
    
    private final boolean revisarGanador() {
        return false;
    }
    
    private final boolean tableroLleno() {
        return false;
    }
    
    private final void reiniciarJuego() {
    }
}