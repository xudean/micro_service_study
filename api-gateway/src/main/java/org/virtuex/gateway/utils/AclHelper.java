package org.virtuex.gateway.utils;
import java.math.BigInteger;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:
 * @date 2019/12/03 18:35
 */
public class AclHelper {
    /**
     * 基于BigInteger的权限计算
     * @param rights 接口ID集合
     * @return
     */
    public static BigInteger sumRights(Integer[] rights){
        BigInteger num = new BigInteger("0");
        for(int i=0; i<rights.length; i++){
            num = num.setBit(rights[i]);
        }
        return num;
    }

    /**
     * 鉴权
     * @param sum 用户权限值
     * @param targetRights 目标接口ID
     *
     * @return
     */
    public static boolean testRights(BigInteger sum,int targetRights){
        return sum.testBit(targetRights);
    }

    /**
     * 鉴权
     * @param sum 用户权限值
     * @param targetRights 目标接口ID
     *
     * @return
     */
    public static boolean testRights(int sum,int targetRights){
        BigInteger sumBigInteger = new BigInteger(sum+"");
        return sumBigInteger.testBit(targetRights);
    }

}