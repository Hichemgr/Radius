<?php

namespace SlimBundle\Repository;

use Doctrine\ORM\EntityRepository;

class VoteRepository extends EntityRepository
{
    public function FindByLetters($string)
    {
        $query = $this->getEntityManager()->createQuery("SELECT a FROM SlimBundle:Vote a WHERE (a.nomproduit like :nomproduit)")
            ->setParameter('nomproduit','%'.$string.'%');

        return $query->getResult();
    }
    public function countnote(){
        $q=$this->getEntityManager()->createQuery("SELECT AVG(v.note) AS Moyenne FROM SlimBundle:Vote v ");

        return $q->getResult();
    }
    public function countnoteZahra(){
        $q=$this->getEntityManager()->createQuery("SELECT AVG(v.note) AS Moyenne FROM SlimBundle:Vote v WHERE v.nomproduit='Zahra'");

        return $q->getResult();
    }
    public function countnotePlanteVerte(){
        $q=$this->getEntityManager()->createQuery("SELECT AVG(v.note) AS Moyenne FROM SlimBundle:Vote v WHERE v.nomproduit='palnteverte'");

        return $q->getResult();
    }
    public function countnotehibiscus(){
        $q=$this->getEntityManager()->createQuery("SELECT AVG(v.note) AS Moyenne FROM SlimBundle:Vote v WHERE v.nomproduit='hibiscus'");

        return $q->getResult();


    }
    public function countnotemarguerite(){
        $q=$this->getEntityManager()->createQuery("SELECT AVG(v.note) AS Moyenne FROM SlimBundle:Vote v WHERE v.nomproduit='marguerite'");

        return $q->getResult();


    }}
