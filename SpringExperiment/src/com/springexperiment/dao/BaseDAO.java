package com.springexperiment.dao;

public interface BaseDAO {
	public enum DAOStatus {
		saved, deleted, operationFailed, modified, notExist, alreadyExist
	}

}
