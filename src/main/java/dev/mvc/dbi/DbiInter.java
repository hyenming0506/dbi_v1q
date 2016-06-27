package dev.mvc.dbi;

import dev.mvc.member.MemberVO;

public interface DbiInter {
  /*<insert id="create" parameterType="MemberVO">*/
  public int create(MemberVO vo);
}
