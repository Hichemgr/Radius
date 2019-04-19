<?php

namespace SlimBundle\Repository;

use Doctrine\ORM\EntityRepository;

class ReclamationRepository extends EntityRepository
{

    public function ReclamationNonTraite(){
        $q=$this->getEntityManager()->createQuery("select c from SlimBundle:Reclamation c where c.etat = 0 ORDER BY c.nomproduit ASC");

        return $q->getResult();
    }
    public function AfficherReclamation(){
        $q=$this->getEntityManager()->createQuery("select c from SlimBundle:Reclamation c  ORDER BY c.nomproduit ASC");

        return $q->getResult();
    }
    public function ReclamationTraite(){
        $q=$this->getEntityManager()->createQuery("select c from SlimBundle:Reclamation c where c.etat = 1 ORDER BY c.nomproduit ASC");

        return $q->getResult();
    }

    public function TraiteReclamation($idreclamation){
        $q=$this->getEntityManager()->createQuery("update SlimBundle:Reclamation c set c.etat=1 where c.idreclamation=:idreclamation ")->setParameter('idreclamation',$idreclamation);

        return $q->getResult();
    }


}
