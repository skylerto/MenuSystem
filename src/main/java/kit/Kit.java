package kit;

import javafx.scene.control.TextField;

/**
 * This class represents the contract for creating kits.
 * <p>
 * Created by Skyler Layne © 2016
 */
public interface Kit<T> {

    /**
     * Instantiate a new <T> from a list of {@link TextField}.
     *
     * @param fields the fields which hold the data.
     * @return a new instantiated class.
     */
    T make(TextField... fields);
}
