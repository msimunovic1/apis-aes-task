package com.apisaes.task.commands.converters;

import com.apisaes.task.commands.OperationCommand;
import hr.aaa.test.v0.datadetails.Operation;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

public class OperationConverter implements Converter<Operation, OperationCommand> {
    @Override
    public Operation convertToDomain(OperationCommand command) {
        Operation operation = null;
        try {
            operation = new Operation();
            operation.setID(command.getId());
            operation.setArrivalDateTime(DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendar(
                            command.getArrivalDateTime()
                    ));
            operation.setStoringFlag(command.getStoringFlag());
            operation.setType(command.getType());
            operation.setAdditionalType(command.getAdditionalType());
            operation.setAcceptanceDate((DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendar(
                            command.getAcceptanceDate()
                    )));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return operation;
    }
}
