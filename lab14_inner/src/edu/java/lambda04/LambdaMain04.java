package edu.java.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMain04 {

    public static void main(String[] args) {
        // Employee를 원소로 갖는 리스트를 선언, 생성
        List<Employee> employees = Arrays.asList(
            new Employee(100, "이존규", "개발자", "개발1팀", 300),
            new Employee(101, "김지훈", "개발자", "개발2팀", 301),
            new Employee(201, "김용훈", "개발자", "개발2팀", 302),
            new Employee(202, "김가영", "디자이너", "개발1팀", 303),
            new Employee(301, "신은정", "디자이너", "개발2팀", 400),
            new Employee(500, "추지훈", "부사장", "인사팀", 1000)
        );
        
        // Ex 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
        for(Employee x : employees) {
            System.out.println("직원들의 정보 : " + x);
        }
        System.out.println();
        
        // Ex 2. job이 "개발자"인 직원들의 급여 합계를 출력.
        int result = 0;
        for(Employee x : employees) {
            if(x.getJob().equals("개발자")) {
                result += x.getSalary();
            }
        }
        System.out.println("개발자인 직원들의 급여 합 : " + result);

        // Ex 3. dept가 "개발2팀'인 직원들의 급여 평균을 출력.
        result = 0;
        int count = 0;
        for(Employee x : employees) {
            if(x.getDept().equals("개발2팀")) {
                result += x.getSalary();
                count++;
            }
        }
        System.out.println("개발2팀 직원들의 급여 평균 : " + result / count);

        // Ex 4. 급여가 400 이상인 직원들의 정보를 한 줄씩 출력.
        List<Employee> resultList = new ArrayList<>();
        resultList = employees.stream()
                .filter( x -> x.getSalary() >= 400 )
                .collect(Collectors.toList());
        
        for(Employee x : resultList) {
            System.out.println("급여가 400이상인 직원들의 정보 : " + x);
        }
        
        
    }

}
