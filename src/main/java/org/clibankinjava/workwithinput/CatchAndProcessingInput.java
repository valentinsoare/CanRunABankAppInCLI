package org.clibankinjava.workwithinput;

import org.clibankinjava.components.Component;

public interface CatchAndProcessingInput extends Component {
    String catchInputFromUser();
    String processingInput(String inputFromUser);
}
