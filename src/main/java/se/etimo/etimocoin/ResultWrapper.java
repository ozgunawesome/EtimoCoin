package se.etimo.etimocoin;

/**
 * Created by ozgunayaz on 1/19/17.
 * license: https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

public class ResultWrapper {

    private boolean result;

    public ResultWrapper(boolean result) {
        this.result = result;
    }

    public ResultWrapper() {
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
