package interfaces;

import beans.Result;

import java.io.Closeable;

public interface ResultDao extends Closeable {
    Result nextResult();

    boolean hasResult();
}
