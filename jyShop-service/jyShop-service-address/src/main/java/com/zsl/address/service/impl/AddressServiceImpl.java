package com.zsl.address.service.impl;

import com.zsl.address.mapper.AddressMapper;
import com.zsl.address.service.IAddressService;
import entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public boolean addNewAddress(Address address) {
        return addressMapper.addNewAddress(address);
    }

    @Override
    public List<Address> selectAddressByUserId(long userId) {
        return addressMapper.selectAddressByUserId(userId);
    }

    @Transactional
    @Override
    public boolean deleteAddress(long addressId) {
        if (addressMapper.isExitAddress(addressId) >= 1) {
            return addressMapper.deleteAddress(addressId) >= 1;
        } else {
            return true;
        }
    }

    @Transactional
    @Override
    public boolean updateAddress(Address address) {
        if (addressMapper.isExitAddress(address.getId()) >= 1) {
            return addressMapper.updateAddress(address) >= 1;
        } else {
            return true;
        }
    }
}
