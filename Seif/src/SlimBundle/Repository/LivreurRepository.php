<?php


namespace SlimBundle\Repository;
use Doctrine\ORM\EntityRepository;
/**
* @ORM\Entity(repositoryClass="SlimBundle\Repository\LivreurRepository")
*/
class LivreurRepository extends EntityRepository
{

 /*  public function getLivreurDispo()
   {
       return $query=$this->getEntityManager()
           ->createQuery("Select l from SlimBundle:Livreur l where m.etat=0")
           ->getResult();
   }*/

}