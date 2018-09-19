  

/*     $('#TableName').bootstrapTable('mergeCells', { index: 0, field: '类别名称', colspan: 0, rowspan: 1});

        index  是重第几行开始           colspan ： 跨几列    rowspan ： 跨几行*/

/**
   * 合并单元格
   * @param data  原始数据（在服务端完成排序）
   * @param fieldName 合并属性名称
   * @param colspan   合并列
   * @param target    目标表格对象
   */
  function mergeCells(data,fieldName,colspan,target){
      //声明一个map计算相同属性值在data对象出现的次数和
      var sortMap = {};
      for(var i = 0 ; i < data.length ; i++){
          for(var prop in data[i]){
              if(prop == fieldName){
                  var key = data[i][prop]
                  if(sortMap.hasOwnProperty(key)){
                      sortMap[key] = sortMap[key] * 1 + 1;
                  } else {
                      sortMap[key] = 1;
                  }
                  break;
              } 
          }
      }
      for(var prop in sortMap){
          console.log(prop,sortMap[prop])
      }
      var index = 0;
      for(var prop in sortMap){
          var count = sortMap[prop] * 1;
          $(target).bootstrapTable('mergeCells',{index:index, field:fieldName, colspan: colspan, rowspan: count});   
          index += count;
      }
  }