package com.agentplannertool.backend.setup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.agentplannertool.frontend.setup.dto.BusinessExpDto;


public class BusinessExpDao {
	
	public String updateBusinessExpToDB(Connection con,BusinessExpDto businessExpDto) throws Exception{
		String sql="UPDATE business_expenses set desk_fee=?,mls_dues=?,mls_lockbox=?,telephone=?,cellphone=?,internet=?,software=?,supplies=?,maintanance=?,car_payment=?,gasandoil=?,car_maintanance=?,car_insurance=?,business_meals=?,business_entertainment=?,seminar=?,lead=?,postcards=?,postage=?,flyers=?,signs=?,website=?,internet_marketing=?,print_ads=?,legal_services=?,accounting_services=?,assistant_salary=?,payroll_taxes=?,transaction_coordinator=?,listing_coordinator=?,dues=?,license=?,eo_insurance=?,industrial_insurance=?,medical_insurance=?,disability_insurance=?,charity=?,total=? where username=? and year=?";
		String update_result="fail";
		String sql2="UPDATE income_goal set business_expenses=? where username=? and year=?";
		
		
			PreparedStatement pstmt=con.prepareStatement(sql);
			PreparedStatement pstmt2=con.prepareStatement(sql2);// for updating business_exp total to income_goals.
			pstmt.setDouble(1,businessExpDto.getPay1());
			pstmt.setDouble(2,businessExpDto.getPay2());
			pstmt.setDouble(3,businessExpDto.getPay3());
			pstmt.setDouble(4,businessExpDto.getPay4());
			pstmt.setDouble(5,businessExpDto.getPay5());
			pstmt.setDouble(6,businessExpDto.getPay6());
			pstmt.setDouble(7,businessExpDto.getPay7());
			pstmt.setDouble(8,businessExpDto.getPay8());
			pstmt.setDouble(9,businessExpDto.getPay9());
			pstmt.setDouble(10,businessExpDto.getPay10());
			pstmt.setDouble(11,businessExpDto.getPay11());
			pstmt.setDouble(12,businessExpDto.getPay12());
			pstmt.setDouble(13,businessExpDto.getPay13());
			pstmt.setDouble(14,businessExpDto.getPay14());
			pstmt.setDouble(15,businessExpDto.getPay15());
			pstmt.setDouble(16,businessExpDto.getPay16());
			pstmt.setDouble(17,businessExpDto.getPay17());
			pstmt.setDouble(18,businessExpDto.getPay18());
			pstmt.setDouble(19,businessExpDto.getPay19());
			pstmt.setDouble(20,businessExpDto.getPay20());
			pstmt.setDouble(21,businessExpDto.getPay21());
			pstmt.setDouble(22,businessExpDto.getPay22());
			pstmt.setDouble(23,businessExpDto.getPay23());
			pstmt.setDouble(24,businessExpDto.getPay24());
			pstmt.setDouble(25,businessExpDto.getPay25());
			pstmt.setDouble(26,businessExpDto.getPay26());
			pstmt.setDouble(27,businessExpDto.getPay27());
			pstmt.setDouble(28,businessExpDto.getPay28());
			pstmt.setDouble(29,businessExpDto.getPay29());
			pstmt.setDouble(30,businessExpDto.getPay30());
			pstmt.setDouble(31,businessExpDto.getPay31());
			pstmt.setDouble(32,businessExpDto.getPay32());
			pstmt.setDouble(33,businessExpDto.getPay33());
			pstmt.setDouble(34,businessExpDto.getPay34());
			pstmt.setDouble(35,businessExpDto.getPay35());
			pstmt.setDouble(36,businessExpDto.getPay36());
			pstmt.setDouble(37,businessExpDto.getPay37());			
			pstmt.setDouble(38,businessExpDto.getTotal());
			pstmt.setString(39,businessExpDto.getUsername());
			pstmt.setInt(40,businessExpDto.getYear());
			
			//settitng for pstmt2;
			pstmt2.setDouble(1,businessExpDto.getTotal());
			pstmt2.setString(2,businessExpDto.getUsername());
			pstmt2.setInt(3,businessExpDto.getYear());
			
			int r=pstmt.executeUpdate();
			if(r>0){
				int r1=pstmt2.executeUpdate();
				if(r1>0){
					update_result="success";
				}
			}
		
		return update_result;
	}
	
	public BusinessExpDto viewBusinessExpFromDB(Connection con,String username,int year)throws Exception{
		String sql="SELECT * FROM business_expenses where username=? and year=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setInt(2,year);
		ResultSet rs=pstmt.executeQuery();
		BusinessExpDto businessExpDto=new BusinessExpDto();
		if(rs.next()){
			businessExpDto.setPay1(rs.getDouble(1));
			businessExpDto.setPay2(rs.getDouble(2));
			businessExpDto.setPay3(rs.getDouble(3));
			businessExpDto.setPay4(rs.getDouble(4));
			businessExpDto.setPay5(rs.getDouble(5));
			businessExpDto.setPay6(rs.getDouble(6));
			businessExpDto.setPay7(rs.getDouble(7));
			businessExpDto.setPay8(rs.getDouble(8));
			businessExpDto.setPay9(rs.getDouble(9));
			businessExpDto.setPay10(rs.getDouble(10));
			businessExpDto.setPay11(rs.getDouble(11));
			businessExpDto.setPay12(rs.getDouble(12));
			businessExpDto.setPay13(rs.getDouble(13));
			businessExpDto.setPay14(rs.getDouble(14));
			businessExpDto.setPay15(rs.getDouble(15));
			businessExpDto.setPay16(rs.getDouble(16));
			businessExpDto.setPay17(rs.getDouble(17));
			businessExpDto.setPay18(rs.getDouble(18));
			businessExpDto.setPay19(rs.getDouble(19));			
			businessExpDto.setPay20(rs.getDouble(20));
			businessExpDto.setPay21(rs.getDouble(21));
			businessExpDto.setPay22(rs.getDouble(22));
			businessExpDto.setPay23(rs.getDouble(23));			
			businessExpDto.setPay24(rs.getDouble(24));
			businessExpDto.setPay25(rs.getDouble(25));
			businessExpDto.setPay26(rs.getDouble(26));
			businessExpDto.setPay27(rs.getDouble(27));
			businessExpDto.setPay28(rs.getDouble(28));
			businessExpDto.setPay29(rs.getDouble(29));
			businessExpDto.setPay30(rs.getDouble(30));
			businessExpDto.setPay31(rs.getDouble(31));
			businessExpDto.setPay32(rs.getDouble(32));
			businessExpDto.setPay33(rs.getDouble(33));
			businessExpDto.setPay34(rs.getDouble(34));
			businessExpDto.setPay35(rs.getDouble(35));
			businessExpDto.setPay36(rs.getDouble(36));
			businessExpDto.setPay37(rs.getDouble(37));
			businessExpDto.setTotal(rs.getDouble(38));
		}
		return businessExpDto;
		
	}

}
