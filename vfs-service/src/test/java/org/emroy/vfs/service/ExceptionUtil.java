package org.emroy.vfs.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.opentest4j.AssertionFailedError;
import vfs.VfsException;
import vfs.VfsExceptionType;

import java.util.Arrays;


/**
 * Created by Karl H on 26/06/2017.
 */

/**
 * Throw util
 */

public  class ExceptionUtil {

    /**
     * Expect a lambda to throw exceptions of specific type
     * @param exception
     * @param action lambda that should throw exception
     * @param message message to display if lambda dooesn't throw
     * @param expectedExpections list of elligible exceptions
     * @param <T> exception type
     */
    public static <T extends Throwable> void expectThrow(Class<T> exception, Executable action, String message,
                                                         VfsExceptionType... expectedExpections) {
        try {
            T ex = Assertions.assertThrows(exception, action);
            if (!(ex instanceof VfsException)) {
                Assertions.fail(ex);
            }
           if ( Arrays.stream(expectedExpections).noneMatch(f-> f.equals( ((VfsException) ex).getType())) )
           {
                Assertions.fail(ex.getMessage());
            }

        } catch (AssertionFailedError e) {
            Assertions.fail(message);
        }
    }
}

